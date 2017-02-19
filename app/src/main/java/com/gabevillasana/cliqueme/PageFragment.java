package com.gabevillasana.cliqueme;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends android.support.v4.app.Fragment {
    TextView name;
    TextView date;
    TextView times;
    TextView description;
    TextView place;


    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.page_fragment_layout, container, false);
        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("eventNum"));
        name = (TextView)view.findViewById(R.id.name);
        name.setText("Name " + events.get(message).getName());
        date = (TextView)view.findViewById(R.id.date);
        date.setText("Date " + events.get(message).getDate());
        times = (TextView)view.findViewById(R.id.times);
        times.setText(events.get(message).getStartTime() + " - " + events.get(message).getEndTime());
        description = (TextView)view.findViewById(R.id.description);
        description.setText("Description " + events.get(message).getDescription());
        place = (TextView)view.findViewById(R.id.place);
        place.setText("Place " + events.get(message).getPlace());
        return  view;
    }

}
