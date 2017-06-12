package project.customlist.com.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import project.customlist.com.myapplication.R;
import project.customlist.com.myapplication.card.CardItem;
import project.customlist.com.myapplication.util.Utils;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Admin on 3/20/2016.
 */
public class CardAdapter extends ArrayAdapter<CardItem> {

    ArrayList<Integer>          layouts = new ArrayList<Integer>();
    Context                     context;
    ArrayList<CardItem>     cardItems;

    public CardAdapter(Context context, int base_layout, ArrayList<CardItem> cardItems, ArrayList<Integer> other_layouts)
    {
        super(context, base_layout, cardItems);
        this.context = context;
        this.layouts.add(base_layout);
        this.layouts.addAll(other_layouts);
        this.cardItems = cardItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        CardItem cardItem = cardItems.get(position);

        convertView = inflater.inflate(getCardLayout(cardItem), null);
        initializeView(convertView, cardItem);

        return convertView;
    }

    public void initializeView(View view, CardItem cardItem)
    {
        if (cardItem.type.equals("story"))
        {
            ((TextView) view.findViewById(R.id.txt_header)).setText(cardItem.story.title);
            ((TextView) view.findViewById(R.id.txt_content)).setText(cardItem.story.description);

            if (cardItem.story.media != null)
            {
                ImageLoader.getInstance().displayImage(cardItem.story.media.image, (ImageView) view.findViewById(R.id.bg_header), Utils.getDisplayImageOptionsInstance());
            }
        }
        else if (cardItem.type.equals("basic"))
        {
            ((TextView) view.findViewById(R.id.txt_header)).setText(cardItem.basic.title);
        }
    }

    public int getCardLayout(CardItem cardItem)
    {
        if (cardItem.type.equals("story"))
        {
            if (cardItem.format.equals("small") && cardItem.story.media == null)
            {
                return layouts.get(2);
            }
            else if (cardItem.format.equals("small") && cardItem.story.media != null)
            {
                return layouts.get(3);
            }
            else if (cardItem.format.equals("medium") && cardItem.story.media == null)
            {
                return layouts.get(4);
            }
            else if (cardItem.format.equals("medium") && cardItem.story.media != null)
            {
                return layouts.get(5);
            }
        }
        else if (cardItem.type.equals("basic"))
        {
            return layouts.get(0);
        }
        return 0;
    }
}
