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


    }
}
