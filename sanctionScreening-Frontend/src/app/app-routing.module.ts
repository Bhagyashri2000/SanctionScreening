import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
// import { ScreeningPassListComponent } from './screening-pass-list/screening-pass-list.component';
// import { TransactionListComponent } from './transaction-list/transaction-list.component';
import { ValidateTransactionComponent } from './validate-transaction/validate-transaction.component';
// import { ValidationFailListComponent } from './validation-fail-list/validation-fail-list.component';
// import { ValidationPassListComponent } from './validation-pass-list/validation-pass-list.component';
// import{ ScreenFailListComponent} from './screen-fail-list/screen-fail-list.component';
import { HomeComponent } from './screen-transaction/screen-transaction.component';

const routes: Routes = [
  // {path: 'transaction', component:TransactionListComponent },
  {path:'upload', component:ValidateTransactionComponent},
  // { path:'validationPass',component: ValidationPassListComponent},
  // { path:'home/validationFail',component:ValidationFailListComponent},
  // {path:'home/screenPass',component:ScreeningPassListComponent},
  // {path: 'home/screenFail',component:ScreenFailListComponent},
  {path:'home',component:HomeComponent},
  {path: '',redirectTo:'upload',pathMatch:'full'}  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }