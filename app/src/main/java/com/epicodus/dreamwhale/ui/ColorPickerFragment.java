package com.epicodus.dreamwhale.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.util.Constants;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ColorPickerFragment extends BaseFragment {
    private int mPickedColor;
    @Bind(R.id.colorPicker) ColorPicker mColorPicker;
    @Bind(R.id.opacitybar) OpacityBar mOpacityBar;
    @Bind(R.id.saturationbar) SaturationBar mSaturationBar;
    @Bind(R.id.valuebar) ValueBar mValueBar;

    public static ColorPickerFragment newInstance() {
        ColorPickerFragment colorFragment = new ColorPickerFragment();
        return colorFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_picker, container, false);
        ButterKnife.bind(this, view);
        mColorPicker.addValueBar(mValueBar);
        mColorPicker.addSaturationBar(mSaturationBar);
        mColorPicker.addOpacityBar(mOpacityBar);
        mColorPicker.setShowOldCenterColor(false);

        mColorPicker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                mPickedColor = color;
                mSharedPreferencesEditor.putString(Constants.COLOR, mPickedColor + "").apply();
            }
        });
        return view;
    }
}
