//
//  Agent.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 26/7/2024.
//

import Foundation
import FirebaseFirestore

class Agent {
    var id: String!
    var agentName: String
    var currentMission: String
    var level: Int
    var exp: Int
    var badges: [String]
    var friends: [String] = [] // don't need a sub coll because need the friend data to update
    
    init(id: String!, agentName: String, currentMission: String, level: Int, exp: Int, badges: [String]) {
        self.id = id
        self.agentName = agentName
        self.currentMission = currentMission
        self.level = level
        self.exp = exp
        self.badges = badges
    }
    
    convenience init(id: String, dictionary: [String: Any]) {
        self.init(
            id: id,
            agentName: dictionary["agentName"] as! String,
            currentMission: dictionary["currentMission"] as! String,
            level: dictionary["level"] as! Int,
            exp: dictionary["exp"] as! Int,
            badges: dictionary["badges"] as! [String]
        )
        
        self.friends = dictionary["friends"] as? [String] ?? []
    }
    
    // print data in a semi-formatted way
    func toString() -> String {
        return """
        Agent Name: \(agentName)
        ID: \(id ?? "Unknown")
        Level: \(level)
        Current Mission: \(currentMission)
        Experience Points: \(exp)
        Badges: \(badges.joined(separator: ", "))
        """
    }
}


