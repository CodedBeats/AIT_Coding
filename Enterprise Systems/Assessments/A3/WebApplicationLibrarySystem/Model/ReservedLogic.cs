using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class ReservedLogic
    {
        public List<Reserved> FindReservedByUserID(string inputUserID)
        {
            ReservedDAO reservedDAO = new ReservedDAO();
            // create list of reserves
            List<Reserved> reserves = reservedDAO.FindReservedByUserID(inputUserID);

            return reserves;
        }

        public bool ReserveBook(string bookName, string username)
        {
            ReservedDAO reservedDAO = new ReservedDAO();
            bool successfulReserve = reservedDAO.ReserveBook(bookName, username);
            return successfulReserve;
        }
    }
}
