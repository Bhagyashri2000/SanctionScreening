import { Component, OnInit } from '@angular/core';
import { ValidationService} from '../validation.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-validate-transaction',
  templateUrl: './validate-transaction.component.html',
  styleUrls: ['./validate-transaction.component.css']
})
export class ValidateTransactionComponent implements OnInit {

  bool: boolean;
  fileUrl:String;

  constructor(private validationservice: ValidationService,
    private router: Router) { }
  saveFile()
  {
    this.validationservice.uploadFile(this.fileUrl).subscribe(data=>
      {
        console.log(data);
        this.goToHome();
      },
      error=>console.error(error));
  }
  goToHome()
  {
    this.router.navigate(['/home']);
  }
  onSubmit()
  {
    this.saveFile();
  }
  ngOnInit(): void {
  }

}
