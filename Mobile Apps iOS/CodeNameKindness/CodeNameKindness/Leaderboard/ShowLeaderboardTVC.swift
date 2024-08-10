//
//  ShowLeaderboardTVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 27/7/2024.
//

import UIKit
import FirebaseAuth

class ShowLeaderboardTVC: UITableViewController {
    
    let repository = Repository()
    var agents = [Agent]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // fetch all agents
        repository.fetchAllAgentsSortedByLevel { [weak self] (agents, error) in
            if let error = error {
                print("error fetching agents: \(error.localizedDescription)")
            } else if let agents = agents {
                self?.agents = agents
                self?.tableView.reloadData()
            }
        }
    }

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return agents.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "AgentRankedCell", for: indexPath) as! AgentRankedTVCell
        
        // get agent in cell
        let agent = agents[indexPath.row]
        
        cell.rankingLabel.text = "#\(indexPath.row + 1)"
        cell.agentNameLabel.text = agent.agentName
        cell.levelLabel.text = "Level \(agent.level)"
        
        // handle setup and actions for btn
        handleFriendButton(forCell: cell, withAgent: agent, atIndex: indexPath)
        
        return cell
    }

    // handle pressed btn
    @objc func addFriendButtonPressed(_ sender: UIButton) {
        let agent = agents[sender.tag]
        let userId = Auth.auth().currentUser?.uid
        
        guard let userId = userId, userId != agent.id else {
            print("lol, this guy wants to be his own friend")
            return
        }
        
        repository.addFriend(forUserID: userId, withFriendID: agent.id) { [weak self] success in
            if success {
                let indexPath = IndexPath(row: sender.tag, section: 0)
                if let cell = self?.tableView.cellForRow(at: indexPath) as? AgentRankedTVCell {
                    self?.handleFriendButton(forCell: cell, withAgent: agent, atIndex: indexPath)
                }
            }
        }
    }
    
    // setup for styles
    private func handleFriendButton(forCell cell: AgentRankedTVCell, withAgent agent: Agent, atIndex indexPath: IndexPath) {
        isCurrentUserFriend(of: agent.id) { isFriend in
            DispatchQueue.main.async {
                cell.friendBtn.setTitle(isFriend ? "-" : "+", for: .normal)
                cell.friendBtn.tag = indexPath.row
                cell.friendBtn.addTarget(self, action: #selector(self.addFriendButtonPressed(_:)), for: .touchUpInside)
                
                cell.friendBtn.backgroundColor = isFriend ? UIColor.systemGreen : UIColor.systemBlue
                cell.friendBtn.setTitleColor(UIColor.white, for: .normal)
            }
        }
    }
    
    // utility func to check if an ID exists in the user's friends arr
    private func isCurrentUserFriend(of agentId: String, completion: @escaping (Bool) -> Void) {
        guard let userId = Auth.auth().currentUser?.uid else {
            completion(false)
            return
        }
        
        repository.fetchAgent(withId: userId) { (returnedAgent, error) in
            if let error = error {
                print("error fetching agent: \(error.localizedDescription)")
                completion(false)
                
            } else if let fetchedAgent = returnedAgent {
                let isFriend = fetchedAgent.friends.contains(agentId)
                // return is or isn't friend in bool
                completion(isFriend)
                
            } else {
                completion(false)
            }
        }
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
