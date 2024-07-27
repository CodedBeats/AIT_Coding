//
//  Extensions.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 26/7/2024.
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

extension UIViewController {
    // popup message
    func showAlertMessage( title: String, message : String){
        // configure alert element
        let alert = UIAlertController(title: title, message: message, preferredStyle: .actionSheet)
        
        // add action
        alert.addAction(UIAlertAction(title: "OK", style: .default))
        
        // show
        present(alert, animated: true, completion: nil)
    }
    
    
    func showAlertMessageWithHandle(title: String, message : String, onComplete : (()->Void)? ){
        let alert = UIAlertController(title: title, message: message, preferredStyle: .actionSheet)
        
        let onCompleteAction: UIAlertAction = UIAlertAction(title: "OK", style: .default){ action in
            onComplete?()
        }
        
        alert.addAction(onCompleteAction)
        
        present(alert, animated: true, completion: nil)
    }
    
    
    
    func deleteConfirmationMessage(title : String, message : String, delete : ( () -> Void )?, cancel: ( () -> Void )? ){
        let alert = UIAlertController(title: title, message: message, preferredStyle: UIAlertController.Style.actionSheet)
       
       
        let deleteAction: UIAlertAction = UIAlertAction(title: "Delete", style: .destructive) {
            action -> Void in delete?()
        }
       
        let cancelAction: UIAlertAction = UIAlertAction(title: "Cancel", style: .default) {
            action -> Void in cancel?()
        }
       
        alert.addAction(cancelAction)
        alert.addAction(deleteAction)
   
        present(alert, animated: true, completion: nil)
       
    }
}
