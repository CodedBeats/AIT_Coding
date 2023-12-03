using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using Model;

namespace WebApplicationLibrarySystem
{
    /// <summary>
    /// Summary description for WebServiceLibrarySystem
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebServiceLibrarySystem : System.Web.Services.WebService
    {
        // === User === //
        UserLogic userLogic = new UserLogic();

        [WebMethod]
        public List<User> GetAllUsers()
        {
            return userLogic.GetAllUsers();
        }

        [WebMethod]
        public UserType ValidateLogin(string userNameInput, string passwordInput)
        {
            return userLogic.ValidateLogin(userNameInput, passwordInput);
        }

        [WebMethod]
        public void CreateUser(string username, string password, int userLevel)
        {
            userLogic.CreateUser(username, password, userLevel);
        }

        [WebMethod]
        public void UpdateUser(string username, string password, int userLevel, int userID)
        {
            userLogic.UpdateUser(username, password, userLevel, userID);
        }

        [WebMethod]
        public void DeleteUser(int userID)
        {
            userLogic.DeleteUser(userID);
        }


        // === Book === //
        BookLogic bookLogic = new BookLogic();

        [WebMethod]
        public List<Book> GetAllBooks()
        {
            return bookLogic.GetAllBooks();
        }

        [WebMethod]
        public List<Book> FindBookByName(string searchInput)
        {
            return bookLogic.FindBookByName(searchInput);
        }

        [WebMethod]
        public List<Book> FindBookByAuthor(string searchInput)
        {
            return bookLogic.FindBookByAuthor(searchInput);
        }

        [WebMethod]
        public List<Book> FindBookByCategory(string searchInput)
        {
            return bookLogic.FindBookByCategory(searchInput);
        }

        [WebMethod]
        public void CreateBook(string bookName, int publishYear, int pages, string publisher)
        {
            bookLogic.CreateBook(bookName, publishYear, pages, publisher);
        }

        [WebMethod]
        public void UpdateBook(string bookName, string originalBookName)
        {
            bookLogic.UpdateBook(bookName, originalBookName);
        }

        [WebMethod]
        public void DeleteBook(string bookName)
        {
            bookLogic.DeleteBook(bookName);
        }



        // === Borrow === //
        BorrowLogic borrowLogic = new BorrowLogic();

        [WebMethod]
        public List<Borrow> FindBorrowByUserID(string inputUserID)
        {
            return borrowLogic.FindBorrowByUserID(inputUserID);
        }

        [WebMethod]
        public bool BorrowBook(string bookName, string username)
        {
            return borrowLogic.BorrowBook(bookName, username);
        }

        [WebMethod]
        public bool ReturnBook(string bookName, string username)
        {
            return borrowLogic.ReturnBook(bookName, username);
        }



        // === Reserve === //
        ReservedLogic reservedLogic = new ReservedLogic();

        [WebMethod]
        public List<Reserved> FindReservedByUserID(string inputUserID)
        {
            return reservedLogic.FindReservedByUserID(inputUserID);
        }

        [WebMethod]
        public bool ReserveBook(string bookName, string username)
        {
            return reservedLogic.ReserveBook(bookName, username);
        }



        // === Language === //
        LanguageLogic languageLogic = new LanguageLogic();

        [WebMethod]
        public List<Language> GetAllLanguages()
        {
            return languageLogic.GetAllLanguages();
        }

        [WebMethod]
        public void CreateLanguage(string languageName)
        {
            languageLogic.CreateLanguage(languageName);
        }

        [WebMethod]
        public void UpdateLanguage(string languageName, int languageID)
        {
            languageLogic.UpdateLanguage(languageName, languageID);
        }

        [WebMethod]
        public void DeleteLanguage(int languageID)
        {
            languageLogic.DeleteLanguage(languageID);
        }



        // === Category === //
        CategoryLogic categoryLogic = new CategoryLogic();

        [WebMethod]
        public List<Category> GetAllCategories()
        {
            return categoryLogic.GetAllCategories();
        }

        [WebMethod]
        public void CreateCategory(string categoryName)
        {
            categoryLogic.CreateCategory(categoryName);
        }

        [WebMethod]
        public void UpdateCategory(int categoryID, string categoryName)
        {
            categoryLogic.UpdateCategory(categoryID, categoryName);
        }

        [WebMethod]
        public void DeleteCategory(int categoryID)
        {
            categoryLogic.DeleteCategory(categoryID);
        }



        // === Author === //
        AuthorLogic authorLogic = new AuthorLogic();

        [WebMethod]
        public List<Author> GetAllAuthors()
        {
            return authorLogic.GetAllAuthors();
        }

        [WebMethod]
        public void CreateAuthor(string authorName)
        {
            authorLogic.CreateAuthor(authorName);
        }

        [WebMethod]
        public void UpdateAuthor(string authorName, int authorID)
        {
            authorLogic.UpdateAuthor(authorName, authorID);
        }

        [WebMethod]
        public void DeleteAuthor(int authorID)
        {
            authorLogic.DeleteAuthor(authorID);
        }
    }
}
