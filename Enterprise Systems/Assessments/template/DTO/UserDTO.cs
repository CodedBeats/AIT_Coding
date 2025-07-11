﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DTO
{
    public enum UserType
    {
        NoUser,
        Student,
        StaffOrAdmin
    }

    public class UserDTO
    {
        public int UID { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public int UserLevel { get; set; }
    }
}
