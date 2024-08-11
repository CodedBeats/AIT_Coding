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
    var db = Firestore.firestore()
    
    
    // === CREATE === //
    
    // add agent for signup call
    func addAgent(agent: Agent) -> Bool {
        // get random mission
        let randomMission = Utility.getRandomMission(from: Utility.missionsArr)
        
        var result = true
        let dictionary: [String: Any] = [
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
    
    // add agent as friend to sub collection
    func addFriend(forUserID userId: String, withFriendID friendId: String, completion: @escaping (Bool) -> Void) {
        let userRef = db.collection("agents").document(userId)
        
        // add friendID to arr of friends
        userRef.setData([
            "friends": FieldValue.arrayUnion([friendId])
        ], merge: true) { error in
            if let error = error {
                print("Error adding friend: \(error.localizedDescription)")
                completion(false) // failure
            } else {
                print("Friend added successfully")
                completion(true) // success
            }
        }
    }

    
    
    
    // === READ === //
    
    // get agent for initial load in headquarters
    func fetchAgent(withId id: String, completion: @escaping (Agent?, Error?) -> Void) {
        // ref to the agent's doc
        let docRef = db.collection("agents").document(id)
        
        // add listener for live updates
        docRef.addSnapshotListener { documentSnapshot, error in
            if let error = error {
                completion(nil, error)
                return
            }

            guard let document = documentSnapshot, document.exists, let data = document.data() else {
                completion(nil, nil) // no doc
                return
            }

            let agent = Agent(id: id, dictionary: data)
            completion(agent, nil)
        }
    }
    
    // get all agents sorted by level
    func fetchAllAgentsSortedByLevel(completion: @escaping ([Agent]?, Error?) -> Void) {
        db.collection("agents")
            .order(by: "level", descending: true)
            .addSnapshotListener { snapshot, error in
                if let error = error {
                    // Return error if fetching fails
                    completion(nil, error)
                } else if let snapshot = snapshot {
                    // Map documents to Agent objects
                    let agents = snapshot.documents.compactMap { doc -> Agent? in
                        let data = doc.data()
                        return Agent(id: doc.documentID, dictionary: data)
                    }
                    // Return the array of agents
                    completion(agents, nil)
                }
            }
    }
    
    
    
    
    // === UPDATE === //
    
    // update agent exp for completing mission
    func updateAgentStats(withId id: String, newExp: Int, newLevel: Int, newMission: String, completion: @escaping (Error?) -> Void) {
        // agents coll with specific docID
        let docRef = db.collection("agents").document(id)
        
        // ppdate exp and level fields
        docRef.updateData([
            "currentMission": newMission,
            "exp": newExp,
            "level": newLevel
        ]) { error in
            if let error = error {
                // error
                print("Error updating exp and level: \(error.localizedDescription)")
                completion(error)
            } else {
                // success
                print("Agent exp and level updated successfully")
                completion(nil)
            }
        }
    }
    
    
    
    
    // === DELETE === //
    
}
