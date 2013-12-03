//  PROGRAMMER: Jonathan Vera
//  PANTHERID: 2677306
//  CLASS:          COP 465501 TR 5:00
//  INSTRUCTOR:     Steve Luis  ECS 282
//  ASSIGNMENT:     #1 Quiz Modification
//  DUE:            Wednesday 01/23/2013
//-----------------------------------------------------------------------------------------------------------------------
//Originally created by:
//  BNRViewController.h
//  Quiz
//
//  Created by Michael Ward on 5/9/12.
//  Copyright (c) 2012 Big Nerd Ranch, Inc. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface BNRViewController : UIViewController 
{
    int currentQuestionIndex;
	//Add the totals counters
	int totalQuestionsAsked, totalAnswersShown;
    
    // The model objects
    NSMutableArray *questions;
    NSMutableArray *answers;
    
    // The view objects
    IBOutlet UILabel *questionField;
    IBOutlet UILabel *answerField;
	//Add the totals labels
	IBOutlet UILabel *totalQuestionsAskedLabel;
    IBOutlet UILabel *totalAnswersShownLabel;
}

// Actions for the buttons to invoke
- (IBAction)showQuestion:(id)sender;
- (IBAction)showAnswer:(id)sender;

@end
