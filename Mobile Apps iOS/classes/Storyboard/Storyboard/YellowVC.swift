//
//  YellowVC.swift
//  Storyboard
//
//  Created by Luca Haar on 21/6/2024.
//

import UIKit

class YellowVC: UIViewController {
    
    var myContact: Contact!

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        myContact = Contact(name: "Luca", email: "Luca@Nasa.com", position: "King of Earth")
    }
    
    
    
    // MARK: - Navigation
    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        
        // pass data to MintVC
        if (segue.destination.isKind(of: MintVC.self)) {
            // we are sure the destination is MintVC
            let mintVC: MintVC = segue.destination as! MintVC
            mintVC.recievedContact = myContact
        }
    }
    
    
    @IBAction func unwindToYellowVC(_ unwindSegue: UIStoryboardSegue) {
        let sourceViewController = unwindSegue.source
        // Use data from the view controller which initiated the unwind segue
        
    }

}
