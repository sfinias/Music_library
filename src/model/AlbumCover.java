package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumCover {

    private TrackBean track;

    public TrackBean getTrack() {
        return track;
    }

    public void setTrack(TrackBean track) {
        this.track = track;
    }

    public class TrackBean {

        private AlbumBean album;



        public AlbumBean getAlbum() {
            return album;
        }

        public void setAlbum(AlbumBean album) {
            this.album = album;
        }


        public class AlbumBean {

            private java.util.List<ImageBean> image;

            public List<ImageBean> getImage() {
                return image;
            }

            public void setImage(List<ImageBean> image) {
                this.image = image;
            }

            public class ImageBean {
                @SerializedName("#text")
                private String text;
                private String size;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }
            }

        }

    }

}
