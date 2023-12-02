using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DTO;
using Controller.ServiceReferenceLibrarySystem;
using ReservedDTO = DTO.ReservedDTO;

namespace Controller
{
    public class ReservedController
    {
        // connect to web service
        WebServiceLibrarySystemSoapClient soapClient = new WebServiceLibrarySystemSoapClient();

        public List<ReservedDTO> FindReservedByUserID(string inputUserID)
        {
            // create list
            List<ReservedDTO> reservedDTOs = new List<ReservedDTO>();

            Controller.ServiceReferenceLibrarySystem.Reserved[] reserves = soapClient.FindReservedByUserID(inputUserID);

            foreach (Reserved reserved in reserves)
            {
                // create new bookDTO
                ReservedDTO reservedDTO = new ReservedDTO();

                // assign values
                reservedDTO.RID = reserved.RID;
                reservedDTO.UID = reserved.UID;
                reservedDTO.ISBN = reserved.ISBN;
                reservedDTO.ReservedDate = reserved.ReservedDate;

                // add to list
                reservedDTOs.Add(reservedDTO);
            }

            return reservedDTOs;
        }

        public bool ReserveBook(string bookName, string username)
        {
            return soapClient.ReserveBook(bookName, username);
        }
    }
}
