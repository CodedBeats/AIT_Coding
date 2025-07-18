//
//  ShowFriendsTVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 11/8/2024.
//

import UIKit
import FirebaseAuth

class ShowFriendsTVC: UITableViewController {
    
    let service = Repository()
    var userAuthId: String!
    // init friends arr
    var friends: [Agent] = []

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // unwrap user ID
        guard let userAuthId = Auth.auth().currentUser?.uid else {
            print("User not authenticated")
            return
        }
        
        self.userAuthId = userAuthId
        
        service.fetchAllFriendsSortedByLevel(forAgentId: userAuthId) { (friends, error) in
            if let error = error {
                print("Error fetching sorted friends: \(error.localizedDescription)")
            } else if let friends = friends {
                self.friends = friends
                // reload table with fetched data
                self.tableView.reloadData()
                
                // semi-formatted display of all agent's friends
                for friend in friends {
                    print(friend.toString())
                    print("----------------------------")
                }
                
            } else {
                print("No friends found")
            }
        }
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // number of friends
        return friends.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // Dequeue the reusable cell
        let cell = tableView.dequeueReusableCell(withIdentifier: "friendCell", for: indexPath) as! ShowFriendsTVCell
        
        // Get the friend for this row
        let friend = friends[indexPath.row]
        
        // Configure the cell with friend's data
        cell.agentNameLabel.text = friend.agentName
        cell.levelLabel.text = "Level: \(friend.level)"
        
        // Configure the progress bar for experience points
        let progress = Float(friend.exp) / 100.0
        cell.expProgressBar.setProgress(progress, animated: true)
        
        // badges
        cell.badge1Image.image = friend.badges.contains("badge1") ? UIImage(named: "badge1") : nil
        cell.badge2Image.image = friend.badges.contains("badge2") ? UIImage(named: "badge2") : nil
        cell.badge3Image.image = friend.badges.contains("badge3") ? UIImage(named: "badge3") : nil
        
        // annoying code to get images dimensions to work
        NSLayoutConstraint.activate([
            cell.badge1Image.widthAnchor.constraint(equalToConstant: 30),
            cell.badge1Image.heightAnchor.constraint(equalToConstant: 30),
            cell.badge2Image.widthAnchor.constraint(equalToConstant: 30),
            cell.badge2Image.heightAnchor.constraint(equalToConstant: 30),
            cell.badge3Image.widthAnchor.constraint(equalToConstant: 30),
            cell.badge3Image.heightAnchor.constraint(equalToConstant: 30),
        ])

        return cell
    }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            let agent = friends[indexPath.row]
            
            // confirmation alert
            showConfirmationMessage(
                title: "Delete",
                message: "Are you sure you want to remove \(agent.agentName) as a friend?",
                confirmTitle: "Delete",
                cancelTitle: "Cancel",
                delete: {
                    // remove agent's friendID from their friends
                    self.service.removeFriend(withFriendID: agent.id, forAgentID: self.userAuthId) { error in
                        if let error = error {
                            print("Failed to remove friend: \(error.localizedDescription)")
                        } else {
                            print("Friend removed successfully")
                        }
                    }
                }, cancel: {
                    print("Cancelled")
                }
            )
        } else if editingStyle == .insert {
            // n/a
        }
    }

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
