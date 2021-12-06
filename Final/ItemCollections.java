import java.util.Vector;

public class ItemCollections {
    private Vector<Item> v; // Item을 저장하는 벡터
    public ItemCollections(){
        v = new Vector<>();
    }

    public void addItem(Item item){
        v.add(item);
    }

    public Vector<Item> getItems(){
        return v;
    }

    public Vector<Book> getBooks(){
        Vector<Book> bv = new Vector<>();
        for(Item i : v) if(i instanceof Book) bv.add((Book)i);
        return bv;
    }

    public Vector<Movie> getMovies(){
        Vector<Movie> mv = new Vector<>();
        for(Item i : v) if(i instanceof Movie) mv.add((Movie)i);
        return mv;
    }
}
