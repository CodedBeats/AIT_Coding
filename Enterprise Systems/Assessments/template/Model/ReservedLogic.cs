using DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class ReservedLogic
    {
        public List<ReservedDTO> FindReservedByUserID(string inputUserID)
        {
            ReservedDAO reservedDAO = new ReservedDAO();
            // create list of reserves
            List<Reserved> reserves = reservedDAO.FindReservedByUserID(inputUserID);

            // check if no reserves
            if (reserves == null)
            {
                return null;
            }

            // clone reserves' data into ReservedDTO type reserves
            List<ReservedDTO> reserveDTOs = reserves.Select(reserved => new ReservedDTO
            {
                RID = reserved.RID,
                UID = reserved.UID,
                ISBN = reserved.ISBN,
                ReservedDate = reserved.ReservedDate
            }).ToList();

            return reserveDTOs;
        }

        public bool ReserveBook(string bookName, string username)
        {
            ReservedDAO reservedDAO = new ReservedDAO();
            bool successfulReserve = reservedDAO.ReserveBook(bookName, username);
            return successfulReserve;
        }
    }
}
