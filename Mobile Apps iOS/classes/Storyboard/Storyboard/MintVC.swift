//
//  MintVC.swift
//  Storyboard
//
//  Created by Luca Haar on 21/6/2024.
//

import UIKit

class MintVC: UIViewController {
    
    var recievedContact: Contact!

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        print("\(recievedContact.email)")
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
