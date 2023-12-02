using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Controller.ServiceReferenceLibrarySystem;
using BorrowDTO = DTO.BorrowDTO;

namespace Controller
{
    public class BorrowController
    {
        // connect to web service
        WebServiceLibrarySystemSoapClient soapClient = new WebServiceLibrarySystemSoapClient();

        public List<BorrowDTO> FindBorrowByUserID(string inputUserID)
        {
            // create list
            List<BorrowDTO> borrowDTOs = new List<BorrowDTO>();

            Controller.ServiceReferenceLibrarySystem.Borrow[] borrows = soapClient.FindBorrowByUserID(inputUserID);

            foreach (Borrow borrow in borrows)
            {
                // create new bookDTO
                BorrowDTO borrowDTO = new BorrowDTO();

                // assign values
                borrowDTO.BID = borrow.BID;
                borrowDTO.UID = borrow.UID;
                borrowDTO.ISBN = borrow.ISBN;
                borrowDTO.BorrowDate = borrow.BorrowDate;
                borrowDTO.ReturnDate = borrow.ReturnDate;
                borrowDTO.ActualReturnDate = borrow.ActualReturnDate;
                borrowDTO.LateFee = borrow.LateFee;

                // add to list
                borrowDTOs.Add(borrowDTO);
            }

            return borrowDTOs;
        }


        // borrow book
        public bool BorrowBook(string bookName, string username)
        {
            return soapClient.BorrowBook(bookName, username);
        }


        // return book
        public bool ReturnBook(string bookName, string username)
        {
            return soapClient.ReturnBook(bookName, username);
        }

    }
}
