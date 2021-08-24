import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ValidationService {
  bool: boolean;
  private baseUrl="http://localhost:8080/api/v1/UploadAndValidateTransaction";
  private baseUrl1="http://localhost:8080/api/v1/uploadFile"

  constructor(private httpClient: HttpClient) { }

  validateTransaction() :Observable<boolean>{
    return this.httpClient.get<boolean>("http://localhost:8080/api/v1/UploadAndValidateTransaction");
  }

  uploadFile(fileUrl: String): Observable<Object>
  {
    return this.httpClient.post(`${this.baseUrl}`,fileUrl);
  } 
}
