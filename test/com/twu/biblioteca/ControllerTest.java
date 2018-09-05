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
        assertEquals("Thank you! Enjoy the book",out.get(0));

    }
    @Test
    public void UnSuccessfulCheckout() {
        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);


        ((TestInput) input).setData(1);
        controller.checkout();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("That book is not available.",out.get(0));

    }

    @Test
    public void SuccessfulReturn() {
        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);

        ((TestInput) input).setData(0);
        controller.returnBook();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("Thank you for returning the book.",out.get(0));



    }

    @Test
    public void UnSuccessfulReturn() {
        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);

        ((TestInput) input).setData(1);
        controller.returnBook();
        List<String> out = ((TestOutput) output).getData();
        assertEquals("That is not a valid book to return.",out.get(0));


    }

    @Test
    public void invalidOption() {

        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);

        ((TestInput) input).setData(-1);
        controller.gotoOption();


        List<String> out = ((TestOutput) output).getData();
        assertEquals("Invalid option",out.get(1));



    }

    @Test
    public void quit() {
        BookMenu menu = new FakeMenu();
        InputPort input = new TestInput();
        OutputPort output = new TestOutput();
        BookController controller = new BookController(menu,input,output);
        controller.exit();
        assertEquals(-1,((TestOutput) output).getExitStatus());

    }

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
        private int exitStatus;


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

        @Override
        public void exit() {
            exitStatus = -1;
        }

        public int getExitStatus() {
            return exitStatus;
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
            if(id == 1){
                throw new Exception();
            }

        }

        @Override
        public void checkOutBook(int id) throws Exception {
            if(id == 1){
                throw new Exception();
            }

        }
    }
}
