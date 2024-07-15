//
//  Extensions.swift
//  iostestdomain
//
//  Created by Luca Haar on 28/6/2024.
//

import Foundation
import UIKit


// extending Optional for String
extension Optional where Wrapped == String {
    // isBlank tells if string is nil or has empty spaces
    var isBlank: Bool {
        // check condition at start of procedure
        guard let notNilBool = self else {
            // the value wrapped in optional is nil
            return true
        }
        
        return notNilBool.trimmingCharacters(in: .whitespaces).isEmpty
    }
}


// extend UIViewController
extension UIViewController {
    // popup message
    func showAlertMessage(title: String, message: String) -> Void {
        // configure alert element
        let alert = UIAlertController(title: title, message: message, preferredStyle: .actionSheet)
        
        // add action
        alert.addAction(UIAlertAction(title: "OK", style: .default))
        
        // show
        present(alert, animated: true, completion: nil)
    }
}
