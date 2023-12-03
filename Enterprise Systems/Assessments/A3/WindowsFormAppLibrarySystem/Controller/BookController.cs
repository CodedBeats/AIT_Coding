using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Controller.ServiceReferenceLibrarySystem;
using BookDTO = DTO.BookDTO;

namespace Controller
{
    public class BookController
    {
        // connect to web service
        WebServiceLibrarySystemSoapClient soapClient = new WebServiceLibrarySystemSoapClient();

        public List<BookDTO> GetAllBooks()
        {
            // create list
            List<BookDTO> bookDTOs = new List<BookDTO>();

            Controller.ServiceReferenceLibrarySystem.Book[] books = soapClient.GetAllBooks();

            foreach (Book book in books)
            {
                // create new bookDTO
                BookDTO bookDTO = new BookDTO();

                // assign values
                bookDTO.ISBN = book.ISBN;
                bookDTO.BookName = book.BookName;
                bookDTO.Author = book.Author;
                bookDTO.Category = book.Category;
                bookDTO.Language = book.Language;
                bookDTO.PublishYear = book.PublishYear;
                bookDTO.Publisher = book.Publisher;
                bookDTO.Pages = book.Pages;

                // add to list
                bookDTOs.Add(bookDTO);
            }

            return bookDTOs;
        }

        
        // search criteria
        public List<BookDTO> FindBookByName(string searchInput)
        {
            // create list
            List<BookDTO> bookDTOs = new List<BookDTO>();

            Controller.ServiceReferenceLibrarySystem.Book[] books = soapClient.FindBookByName(searchInput);

            foreach (Book book in books)
            {
                // create new bookDTO
                BookDTO bookDTO = new BookDTO();

                // assign values
                bookDTO.ISBN = book.ISBN;
                bookDTO.BookName = book.BookName;
                bookDTO.Author = book.Author;
                bookDTO.Category = book.Category;
                bookDTO.Language = book.Language;
                bookDTO.PublishYear = book.PublishYear;
                bookDTO.Publisher = book.Publisher;
                bookDTO.Pages = book.Pages;

                // add to list
                bookDTOs.Add(bookDTO);
            }

            return bookDTOs;
        }

        public List<BookDTO> FindBookByAuthor(string searchInput)
        {
            // create list
            List<BookDTO> bookDTOs = new List<BookDTO>();

            Controller.ServiceReferenceLibrarySystem.Book[] books = soapClient.FindBookByAuthor(searchInput);

            foreach (Book book in books)
            {
                // create new bookDTO
                BookDTO bookDTO = new BookDTO();

                // assign values
                bookDTO.ISBN = book.ISBN;
                bookDTO.BookName = book.BookName;
                bookDTO.Author = book.Author;
                bookDTO.Category = book.Category;
                bookDTO.Language = book.Language;
                bookDTO.PublishYear = book.PublishYear;
                bookDTO.Publisher = book.Publisher;
                bookDTO.Pages = book.Pages;

                // add to list
                bookDTOs.Add(bookDTO);
            }

            return bookDTOs;
        }

        public List<BookDTO> FindBookByCategory(string searchInput)
        {
            // create list
            List<BookDTO> bookDTOs = new List<BookDTO>();

            Controller.ServiceReferenceLibrarySystem.Book[] books = soapClient.FindBookByCategory(searchInput);

            foreach (Book book in books)
            {
                // create new bookDTO
                BookDTO bookDTO = new BookDTO();

                // assign values
                bookDTO.ISBN = book.ISBN;
                bookDTO.BookName = book.BookName;
                bookDTO.Author = book.Author;
                bookDTO.Category = book.Category;
                bookDTO.Language = book.Language;
                bookDTO.PublishYear = book.PublishYear;
                bookDTO.Publisher = book.Publisher;
                bookDTO.Pages = book.Pages;

                // add to list
                bookDTOs.Add(bookDTO);
            }

            return bookDTOs;
        }


        // search
        public List<BookDTO> Search(string searchInput, int searchCat)
        {
            // search by book name
            if (searchCat == 1)
            {
                return FindBookByName(searchInput);
            }
            // search by author
            else if (searchCat == 2)
            {
                return FindBookByAuthor(searchInput);
            }
            // search by category
            else
            {
                return FindBookByCategory(searchInput);
            }
        }


        // CRUD
        public void CreateBook(string bookName, int publishYear, int pages, string publisher)
        {
            soapClient.CreateBook(bookName, publishYear, pages, publisher);
        }

        public void UpdateBook(string bookName, string originalBookName)
        {
            soapClient.UpdateBook(bookName, originalBookName);
        }

        public void DeleteBook(string bookName)
        {
            soapClient.DeleteBook(bookName);
        }
    }
}
