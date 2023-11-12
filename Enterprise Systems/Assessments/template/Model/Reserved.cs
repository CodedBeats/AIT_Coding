using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Reserved
    {
        public int RID { get; set; }
        public int UID { get; set; }
        public string ISBN { get; set; }
        public DateTime ReservedDate { get; set; }
    }
}
