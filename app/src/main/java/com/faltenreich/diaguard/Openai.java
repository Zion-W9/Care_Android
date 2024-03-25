package com.faltenreich.diaguard;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

public class Openai extends Fragment {

    private Button buttonRecord;
    private TextView textViewResponse;
    private Handler handler = new Handler();
    private String fullText = "";
    private int index = 0;

    public Openai() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_openai, container, false);

        buttonRecord = view.findViewById(R.id.buttonRecord);
        textViewResponse = view.findViewById(R.id.textViewResponse);

        buttonRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the recording state and update UI accordingly
                if (buttonRecord.getText().toString().equals("Start Recording")) {
                    // Simulate start of recording
                    buttonRecord.setText("Stop Recording");
                    textViewResponse.setText("");
                    fullText = "Recording...";
                    index = 0;
                    handler.postDelayed(characterAdder, 500); // Start after a delay to simulate recording start
                } else {
                    // Simulate stop of recording and prepare for the detailed message
                    buttonRecord.setText("Start Recording");
                    textViewResponse.setText("");
                    fullText = "I'm not a doctor, but I can share some general advice often given to people diagnosed with diabetes. Managing diabetes involves several key areas including diet, exercise, monitoring your blood glucose levels, medication if prescribed, and regular medical checkups. Here's a brief overview:\n" +
                            "\n" +
                            "Healthy Eating: Focus on a balanced diet rich in fruits, vegetables, whole grains, and lean proteins. Limiting sugars and refined carbohydrates is crucial because they can cause rapid spikes in blood sugar levels.\n" +
                            "\n" +
                            "Regular Physical Activity: Exercise can help control your blood sugar levels, reduce your risk of heart disease, and manage your weight. Aim for at least 150 minutes of moderate aerobic activity a week, but always consult with your healthcare provider before starting a new exercise program.\n" +
                            "\n" +
                            "Blood Sugar Monitoring: Keeping track of your blood sugar levels helps you understand how food, activity, and stress affect your diabetes. This can help you and your healthcare team make necessary adjustments to your management plan.\n" +
                            "\n" +
                            "Stay Informed: Diabetes management can change over time as new research and treatments develop. Stay informed about the latest diabetes management strategies and consider joining a support group to connect with others facing similar challenges.\n" +
                            "\n" +
                            "Remember, every person's situation is unique, so it's essential to work closely with your healthcare team to tailor a diabetes management plan that's right for you. They can provide you with the most accurate and personalized advice based on your specific health needs.";
                    index = 0;
                    handler.post(characterAdder); // Immediately start displaying the detailed message
                }
            }
        });

        return view;
    }

    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            if (index < fullText.length()) {
                textViewResponse.setText(fullText.substring(0, index++));
                handler.postDelayed(this, 30); // Schedule the next letter after a short delay
            }
        }
    };
}
