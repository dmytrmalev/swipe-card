package project.customlist.com.myapplication.swipelistview;

public class BaseSwipeListViewListener implements SwipeListViewListener{
    @Override
    public void onOpened(int position, boolean toRight) {
    }

    @Override
    public void onClosed(int position, boolean fromRight) {
    }

    @Override
    public void onListChanged() {
    }

    @Override
    public void onMove(int position, float x) {
    }

    @Override
    public void onStartOpen(int position, int action, boolean right) {
    }

    @Override
    public void onStartClose(int position, boolean right) {
    }

    @Override
    public void onClickFrontView(int position) {
    }

    @Override
    public void onClickBackView(int position) {
    }

    @Override
    public void onDismiss(int[] reverseSortedPositions) {
    }

    @Override
    public int onChangeSwipeMode(int position) {
        return SwipeListView.SWIPE_MODE_DEFAULT;
    }
}