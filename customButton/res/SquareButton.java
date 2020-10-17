public class SquareButton extends androidx.appcompat.widget.AppCompatButton {

    public SquareButton(@NonNull Context context) {
        super(context);
    }

    public SquareButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height= MeasureSpec.getSize(heightMeasureSpec);

        Log.d("main","create");
        Log.d("main","width : "+width+", height : "+height);
        width = Math.min(width,height);
        height = width;

        Log.d("main","width : "+width+", height : "+height);
        setMeasuredDimension(width,height);
    }
}
