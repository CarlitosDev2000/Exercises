package com.carloscordova.my_dialog_exercise;
import android.os.Parcel;
import android.os.Parcelable;
public class User implements Parcelable {
    private String nameUser;
    private int ageUser;
    private String emailUser;
    public User(String nameUser, int ageUser, String emailUser) {
        this.nameUser = nameUser;
        this.ageUser = ageUser;
        this.emailUser = emailUser;
    }
    public String getNameUser() {
        return nameUser;
    }
    public int getAgeUser() {
        return ageUser;
    }
    public String getEmailUser() {
        return emailUser;
    }
    protected User(Parcel userParcel) {
        emailUser = userParcel.readString();
        ageUser = userParcel.readInt();
        nameUser = userParcel.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(emailUser);
        dest.writeInt(ageUser);
        dest.writeString(nameUser);
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
