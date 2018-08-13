package cnhh.lvtn.bangtuanhoan;

public class DayHoatDong {
    private String mIon;
    private String mHoaTri;
    private String mChat;

    public DayHoatDong() {
    }

    public DayHoatDong(String mIon, String mHoaTri, String mChat) {
        this.mIon = mIon;
        this.mHoaTri = mHoaTri;
        this.mChat = mChat;
    }

    public String getIon() {
        return mIon;
    }

    public void setIon(String mIon) {
        this.mIon = mIon;
    }

    public String getHoaTri() {
        return mHoaTri;
    }

    public void setHoaTri(String mHoaTri) {
        this.mHoaTri = mHoaTri;
    }

    public String getChat() {
        return mChat;
    }

    public void setChat(String mChat) {
        this.mChat = mChat;
    }
}
