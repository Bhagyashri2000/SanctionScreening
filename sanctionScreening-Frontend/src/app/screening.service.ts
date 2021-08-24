import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ScreeningService {

  constructor(private httpClient: HttpClient) { }

  screenTransaction() :Observable<boolean>{
    return this.httpClient.get<boolean>("http://localhost:8080/api/v1/screenTransaction");
  }
}
