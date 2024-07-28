//
//  Repository.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 26/7/2024.
//

import Foundation
import FirebaseFirestore
import FirebaseAuth

class Repository {
    var missions: [String] = ["x", "y", "z"]
    var db = Firestore.firestore()
    
    // add agent for signup call
    func addAgent(agent: Agent) -> Bool {
        // get random mission
        let randomMission = Utility.getRandomMission(from: Utility.missionsArr)
        
        var result = true
        var dictionary: [String: Any] = [
            "agentName": "CodeName" + agent.agentName,
            "currentMission": randomMission ?? "Somehow ran out of missions?",
            "level": agent.level,
            "exp": agent.exp,
            "badges": agent.badges,
            "friends": agent.friends
        ]
        
        db.collection("agents").document(agent.id).setData(dictionary){ error in
        
            if let err = error {
                print("agent could not be added \(agent.agentName), error \(err)")
                result = false
            }
        }
        
        return result
        
    }
}
