public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        rootView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity activity = (MainActivity)getActivity();
                activity.onFragmentChange(1);
            }
        });
        return rootView;
    }
}