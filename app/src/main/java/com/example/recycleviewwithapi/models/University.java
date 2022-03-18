package com.example.recycleviewwithapi.models;

import android.os.Parcel;
import android.os.Parcelable;

public class University implements Parcelable {
    private String country;
    private String name;
    private String[] domains;
    private String countryCode;
    private String state;
    private String imageUri = "https://yt3.ggpht.com/URas7CAnhru6m1BybojRtF2tcLE4fKEHn4aTFIf0Mppuizu3Xoi0-NIIMkeczAREjGdU28tQ=s900-c-k-c0x00ffffff-no-rj";
    private String[] webpages;

//    public University() { }

    public University(String country, String name, String[] domains, String countryCode, String state, String[] webpages) {
        this.country = country;
        this.name = name;
        this.domains = domains;
        this.countryCode = countryCode;
        this.state = state;
        this.webpages = webpages;
    }

    protected University(Parcel in) {
        country = in.readString();
        name = in.readString();
        domains = in.createStringArray();
        countryCode = in.readString();
        state = in.readString();
        imageUri = in.readString();
        webpages = in.createStringArray();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getDomains() {
        return domains;
    }

    public void setDomains(String[] domains) {
        this.domains = domains;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String[] getWebpages() {
        return webpages;
    }

    public void setWebpages(String[] webpages) {
        this.webpages = webpages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(country);
        parcel.writeString(name);
        parcel.writeStringArray(domains);
        parcel.writeString(countryCode);
        parcel.writeString(state);
        parcel.writeString(imageUri);
        parcel.writeStringArray(webpages);
    }

    public static final Creator<University> CREATOR = new Creator<University>() {
        @Override
        public University createFromParcel(Parcel in) {
            return new University(in);
        }

        @Override
        public University[] newArray(int size) {
            return new University[size];
        }
    };
}
