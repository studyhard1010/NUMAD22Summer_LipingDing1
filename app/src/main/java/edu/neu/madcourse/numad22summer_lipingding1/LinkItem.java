package edu.neu.madcourse.numad22summer_lipingding1;

public class LinkItem implements ItemClickListener{
    private String name;
    private String url;
    private boolean isChecked;

    public LinkItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void onItemClick(int position) {
        isChecked = !isChecked;
    }
}
