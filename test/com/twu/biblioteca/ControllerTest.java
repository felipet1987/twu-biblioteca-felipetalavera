package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

    @Test
    public void showMenu() {

        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);

        controller.showMenu();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("Welcome",out.get(0));



    }

    @Test
    public void showBooks() {

        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);


        controller.showBooks();
        controller.showBookOptions();

        List<String> out = ((TestOutput) output).getData();

        assertEquals("ID:NAME:AUTHOR:YEAR",out.get(0));




    }

    @Test
    public void showBookOptions() {
        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);
        controller.showBookOptions();

        List<String> out = ((TestOutput) output).getData();

        assertEquals("Choose an option",out.get(0));
        assertEquals("1 . return book",out.get(1));
        assertEquals("2 . checkout book",out.get(2));

    }
    @Test
    public void choosingShowBooksOption() {
        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);

        ((TestInput) input).setData(0);
        controller.gotoOption();


        List<String> out = ((TestOutput) output).getData();
        assertEquals("ID:NAME:AUTHOR:YEAR",out.get(1));


    }

    @Test
    public void SuccessfulCheckout() {
        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);


        ((TestInput) input).setData(0);
        controller.checkout();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("Successful",out.get(0));

    }
    @Test
    public void UnSuccessfulCheckout() {
        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);


        ((TestInput) input).setData(0);
        controller.checkout();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("Unsuccessful",out.get(1));

    }

//    @Test
//    public void SuccessfulReturn() {
//
//    }
//
//    @Test
//    public void UnSuccessfulReturn() {
//
//
//    }
//
//    @Test
//    public void returnToMenu() {
//    }
//
//    @Test
//    public void quit() {
//
//    }

    private class TestInput implements InputPort {
        private int data;



        public TestInput() {

        }

        public void setData(int data){
            this.data = data;
        }

        @Override
        public int getInt() {
            return data;
        }
    }

    private class TestOutput implements OutputPort {

        private List<String> data;




        private TestOutput() {
            data = new ArrayList<String>();
        }
        public List<String> getData(){

            return this.data;
        }


        @Override
        public void print(String message) {
            this.data.add(message);
        }
    }

    private class FakeMenu implements BookMenu {
        @Override
        public String start() {
            return "Welcome";
        }

        @Override
        public List<String[]> getBooks() {
            List<String[]> bookList = new ArrayList<>();

            String[] book = {"1","name","author","2018"};
            bookList.add(book);
            return bookList;
        }

        @Override
        public String[] getMenu() {
            String[] menuView = new String[2];
            menuView[0] = "show available books";
            menuView[1] = "quit";
            return menuView;
        }

        @Override
        public boolean isValid(String option) {
            return false;
        }

        @Override
        public void returnBook(int id) throws Exception {

        }

        @Override
        public void checkOutBook(int id) throws Exception {
            if(id == 1){
                throw new Exception();
            }

        }
    }
}
