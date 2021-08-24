import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class AllTransactionService {

  constructor(private httpClient: HttpClient) { }

  // getAllTransactionList(): Observable<Transaction[]>{
  //   let params = new HttpParams()
  //   .set('status', 'all')
  //   return this.httpClient.get<Transaction[]>("http://localhost:8080/api/v1/filterTransactions/", {params: params});
  // }
  getFilteredTransaction(str):Observable<Transaction[]>{
    let params = new HttpParams()
    .set('status', str)
    return this.httpClient.get<Transaction[]>("http://localhost:8080/api/v1/filterTransactions/", {params: params});
  }
}
