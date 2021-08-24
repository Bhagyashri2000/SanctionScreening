import { Component } from '@angular/core';
import {ScreeningService} from './screening.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  bool : boolean;
  title = 'sanctionScreening';
  transaction: any;
  constructor(){

  }

  
  

}
