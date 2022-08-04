package com.example.e_tuku;

import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileItemData {
    private String iconURL;
    private String text;


    public ProfileItemData(String iconURL, String text) {
        this.iconURL = iconURL;
        this.text = text;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
