package day0328;

import java.util.Calendar;

public class BoardDTO implements Comparable{
    private int id;
    private String title;
    private int writerId;
    private String content;
    private Calendar writtenDate;
    private Calendar updatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(Calendar writtenDate) {
        this.writtenDate = writtenDate;
    }

    public Calendar getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Calendar updatedDate) {
        this.updatedDate = updatedDate;
    }

    public BoardDTO() {

    }

    public BoardDTO(BoardDTO b) {
        id = b.id;
        title = b.title;
        writerId = b.writerId;
        content = b.content;
        writtenDate = Calendar.getInstance();
        writtenDate.setTime(b.writtenDate.getTime());
        updatedDate = Calendar.getInstance();
        updatedDate.setTime(b.updatedDate.getTime());
    }

    public boolean equals(Object o) {
        if (o instanceof BoardDTO) {
            BoardDTO b = (BoardDTO) o;
            return id == b.id;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        // 크면 1, 같으면 0, 작으면 -1 리턴시키기
        
        return 0;
    }

}
