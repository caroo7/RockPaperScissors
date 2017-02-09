import {Http} from '@angular/http';
import 'rxjs/add/operator/map'
import {Injectable} from '@angular/core'

@Injectable()
export class PostService {

    private url = "http://localhost:8080/game"

    constructor(private http: Http) {
    }

    createPost(post) {
        return this.http.post(this.url, JSON.stringify(post))
            .map(res => res.json());
    }

}