//
//  ShowMissionTVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 27/7/2024.
//

import UIKit
import FirebaseAuth

class ShowMissionTVC: UITableViewController {
    
    @IBOutlet weak var currentMissionLabel: UILabel!
    
    let service = Repository()
    var userAuthId: String!
    

    // thius is all pretty gross looking haha, but technically I am passing data on an action, it's just not a segue
    // the point is to not call the repo unecesarily right? (god I can't spoell lol)
    var agent: Agent? {
        didSet {
            // call func to update UI when agent is recieved
            updateUI()
        }
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        updateUI()
    }
    
    func updateUI() {
        guard isViewLoaded, let agent = agent else {
            return
        }
        print("Received agent: \(agent.currentMission)")
        
        // put agent data into UI elemnts
        currentMissionLabel.text = agent.currentMission
    }
    
    
    
    @IBAction func completeMissionBtnDidPress(_ sender: Any) {
        // unwrap user ID
        guard let userAuthId = Auth.auth().currentUser?.uid else {
            print("User not authenticated")
            return
        }
        
        // get random mission
        guard let randomMission = Utility.getRandomMission(from: Utility.missionsArr) else {
            print("Failed to get a random mission")
            return
        }
        
        // unwrap agent's level and exp
        guard let currentLevel = agent?.level, let currentExp = agent?.exp else {
            print("Agent data is not available")
            return
        }
        
        // calculate new experience and level
        var newLvl = currentLevel
        var newExp = currentExp + 30
        if newExp >= 100 {
            newExp -= 100
            newLvl += 1
        }
        
        // update agent
        service.updateAgentExpAndLevel(withId: userAuthId, newExp: newExp, newLevel: newLvl, newMission: randomMission) { error in
            if let error = error {
                // error
                print("Error updating agent: \(error.localizedDescription)")
            } else {
                // success
                print("Agent updated successfully.")
                
                // update agent object locally...this might be wrong :(
                self.agent?.level = newLvl
                self.agent?.exp = newExp
                self.agent?.currentMission = randomMission
                
                // update UI to reflect changes
                self.currentMissionLabel.text = randomMission
            }
        }
    }
    
    @IBAction func passMissionBtnDidPress(_ sender: Any) {
        // unwrap user ID
        guard let userAuthId = Auth.auth().currentUser?.uid else {
            print("User not authenticated")
            return
        }
        
        // get random mission
        guard let randomMission = Utility.getRandomMission(from: Utility.missionsArr) else {
            print("Failed to get a random mission")
            return
        }
        
        // unwrap agent's level and exp
        guard let currentLevel = agent?.level, let currentExp = agent?.exp else {
            print("Agent data is not available")
            return
        }
        
        // Call the service to update the agent's data
        service.updateAgentExpAndLevel(withId: userAuthId, newExp: currentExp, newLevel: currentLevel, newMission: randomMission)
        { error in
            if let error = error {
                // error
                print("Error updating agent: \(error.localizedDescription)")
            } else {
                // success
                print("Agent updated successfully.")
                
                // update agent object locally...this might be wrong :(
                self.agent?.currentMission = randomMission
                
                // update UI to reflect changes
                self.currentMissionLabel.text = randomMission
            }
        }
    }
    

    // MARK: - Table view data source

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
