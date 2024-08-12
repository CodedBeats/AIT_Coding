//
//  ShowAgentReportTVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 27/7/2024.
//

import UIKit
import FirebaseAuth

class ShowAgentReportTVC: UITableViewController {
    
    @IBOutlet weak var agentNameLabel: UILabel!
    @IBOutlet weak var agentExpProgress: UIProgressView!
    @IBOutlet weak var agentLevelLabel: UILabel!
    
    @IBOutlet weak var badge1Image: UIImageView!
    @IBOutlet weak var badge2Image: UIImageView!
    @IBOutlet weak var badge3Image: UIImageView!
    
    let service = Repository()
    var agent: Agent!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        agentNameLabel.text = agent.agentName
        agentExpProgress.progress = Float(agent.exp) / 100.0
        agentLevelLabel.text = String(agent.level)
        
        // badges
        badge1Image.image = agent.badges.contains("badge1") ? UIImage(named: "badge1") : nil
        badge2Image.image = agent.badges.contains("badge2") ? UIImage(named: "badge2") : nil
        badge3Image.image = agent.badges.contains("badge3") ? UIImage(named: "badge3") : nil
        
        // annoying code to get images dimensions to work
        NSLayoutConstraint.activate([
            badge1Image.widthAnchor.constraint(equalToConstant: 40),
            badge1Image.heightAnchor.constraint(equalToConstant: 40),
            badge2Image.widthAnchor.constraint(equalToConstant: 40),
            badge2Image.heightAnchor.constraint(equalToConstant: 40),
            badge3Image.widthAnchor.constraint(equalToConstant: 40),
            badge3Image.heightAnchor.constraint(equalToConstant: 40),
        ])
    }

    
    
    
    
    // MARK: - Table view data source

    @IBAction func changePasswordBtnDidPress(_ sender: Any) {
        // show message with input
        showMessageWithInput(
            title: "Reset Password",
            message: "Please enter your email to reset your password",
            placeholder: "Enter your email",
            actionTitle: "Send Reset Link"
        ) { email in
            // validate email
            if email.isBlank {
                // error alert if email is blank or nil
                self.showAlertMessage(title: "Error", message: "Please enter a valid email address")
                return
            }
            
            // send password reset email
            Auth.auth().sendPasswordReset(withEmail: email!) { error in
                if let error = error {
                    self.showAlertMessage(title: "Error", message: error.localizedDescription)
                } else {
                    self.showAlertMessage(title: "Success", message: "Password reset link has been sent to \(email!)")
                }
            }
        }
    }
    
    @IBAction func logoutBtnDidPress(_ sender: Any) {
        showConfirmationMessage(
            title: "Logout",
            message: "Are you sure you want to log out?",
            confirmTitle: "Logout",
            cancelTitle: "Cancel",
            delete: {
                
                // logout
                do {
                    try Auth.auth().signOut()
                    // navigate back to login
                    self.navigateToAuthScenes()
                    
                } catch let signOutError as NSError {
                    print("Error signing out: ", signOutError.localizedDescription)
                }
            },
            cancel: {
                print("Logout cancelled")
            }
        )
    }
    
    @IBAction func deleteAccountBtnDidPress(_ sender: Any) {
        showConfirmationMessage(
            title: "Delete Account",
            message: "Are you sure you want to delete your account?",
            confirmTitle: "Delete Account",
            cancelTitle: "Cancel",
            delete: {
                                
                // get agent's ID
                guard let userID = Auth.auth().currentUser?.uid else {
                    print("User not logged in")
                    return
                }

                // delete agent from auth and coll
                self.service.deleteAgent(withUserID: userID) { error in
                    if let error = error {
                        // failed
                        self.showAlertMessage(title: "Error", message: "Failed to delete account: \(error.localizedDescription)")
                    } else {
                        // navigate back to login
                        self.navigateToAuthScenes()
                        // success
                        print("Account deleted successfully")
                    }
                }
                
            }, cancel: {
                print("Delete account cancelled")
            }
        )
    }
    
    
    // func to route back to login
    func navigateToAuthScenes() {
        if let loginVC = self.storyboard?.instantiateViewController(withIdentifier: "authNC") as? UINavigationController {
            // set auth navigation controller as root view controller
            self.view.window?.rootViewController = loginVC
            self.view.window?.makeKeyAndVisible()
        }
    }
    
    
    /*
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "reuseIdentifier", for: indexPath)

        // Configure the cell...

        return cell
    }
    */

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
