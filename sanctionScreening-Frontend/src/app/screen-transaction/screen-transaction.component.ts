import { Component, OnInit } from '@angular/core';
import {ScreeningService} from '../screening.service';
import { Router } from '@angular/router';
import { Transaction} from '../transaction';
import { AllTransactionService} from '../all-transaction.service'



@Component({
  selector: 'app-screen-transaction',
  templateUrl: './screen-transaction.component.html',
  styleUrls: ['./screen-transaction.component.css']
})
export class HomeComponent implements OnInit {
  bool:boolean;
  transactions: Transaction[];
  
  constructor(private screeningServive:ScreeningService,
    private allTransactionService: AllTransactionService,) { }
  screenTransaction()
  {
    
    this.screeningServive.screenTransaction().subscribe(data=>
      this.bool=data
      
      )
      
  }
  reload()
  {
    window.location.reload();
  }
 

  getSelectedDropdown(path)
  {
    if(path==0)
    {
      this.getFilteredTransaction('all');
    }
    if(path==1)
    {
      this.getFilteredTransaction('validation pass');
    }
    else if (path==2)
    {
      this.getFilteredTransaction('validation fail');
    }
    else if(path==4)
    {
      this.getFilteredTransaction('screen fail');
    }
    else if(path==3)
    {
      this.getFilteredTransaction('screen pass');
    }
  }

  getFilteredTransaction(str)
  {
    this.allTransactionService.getFilteredTransaction(str).subscribe(data=>{
      this.transactions=data;
    })
  }

  
  ngOnInit(): void {
    this.getFilteredTransaction('all');
  }

}
