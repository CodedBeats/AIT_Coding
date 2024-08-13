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
    // static message
    func showAlertMessage(title: String, message : String){
        // configure alert element
        let alert = UIAlertController(title: title, message: message, preferredStyle: .actionSheet)
        
        // add action
        alert.addAction(UIAlertAction(title: "OK", style: .default))
        
        // show
        present(alert, animated: true, completion: nil)
    }
    
    
    // message with following action
    func showAlertMessageWithHandle(title: String, message : String, onComplete : (()->Void)? ){
        let alert = UIAlertController(title: title, message: message, preferredStyle: .actionSheet)
        
        let onCompleteAction: UIAlertAction = UIAlertAction(title: "OK", style: .default){ action in
            onComplete?()
        }
        
        alert.addAction(onCompleteAction)
        
        present(alert, animated: true, completion: nil)
    }
    
    
    // message with confirmation for following action
    func showConfirmationMessage(title: String, message: String, confirmTitle: String, cancelTitle: String, delete: (() -> Void)?, cancel: (() -> Void)?) {
        let alert = UIAlertController(title: title, message: message, preferredStyle: .actionSheet)

        let deleteAction: UIAlertAction = UIAlertAction(title: confirmTitle, style: .destructive) { action in
            delete?()
        }

        let cancelAction: UIAlertAction = UIAlertAction(title: cancelTitle, style: .cancel) { action in
            cancel?()
        }

        alert.addAction(cancelAction)
        alert.addAction(deleteAction)

        present(alert, animated: true, completion: nil)
    }
    
    // message with input for following action
    func showMessageWithInput(title: String, message: String, placeholder: String, actionTitle: String, completion: @escaping (String?) -> Void) {
        // Configure alert controller
        let alert = UIAlertController(title: title, message: message, preferredStyle: .alert)
        
        // Add text field to the alert for email input
        alert.addTextField { textField in
            textField.placeholder = placeholder
            textField.keyboardType = .emailAddress
        }
        
        // Add action for when the user presses the confirm button
        let confirmAction = UIAlertAction(title: actionTitle, style: .default) { _ in
            // Retrieve the input from the text field
            let email = alert.textFields?.first?.text
            completion(email)
        }
        
        // Add cancel action
        let cancelAction = UIAlertAction(title: "Cancel", style: .cancel, handler: nil)
        
        // Add actions to the alert
        alert.addAction(confirmAction)
        alert.addAction(cancelAction)
        
        // Show the alert
        present(alert, animated: true, completion: nil)
    }
}
