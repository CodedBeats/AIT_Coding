using DTO;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
{
    public class RservedController
    {
        public List<ReservedDTO> FindReservedByUserID(string inputUserID)
        {
            ReservedLogic reservedLogic = new ReservedLogic();
            return reservedLogic.FindReservedByUserID(inputUserID);
        }

        public bool ReserveBook(string bookName, string username)
        {
            ReservedLogic reservedLogic = new ReservedLogic();
            bool successfulReserve = reservedLogic.ReserveBook(bookName, username);
            return successfulReserve;
        }
    }
}
