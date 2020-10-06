
public class ViewerFragment extends Fragment {
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer,container,false);

       imageView = rootView.findViewById(R.id.imageView3);
       return rootView;
    }

    public void setImage(int resId){
        imageView.setImageResource(resId);
    }

}