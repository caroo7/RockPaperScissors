import { RPSResult } from './RPSresult';
import { PostService } from './RPS.post.service'

export class RPSService {

    result : RPSResult

    constructor(private postService : PostService) {
    }

    retrieveResult(computerOption) : RPSResult {
        this.postService.createPost(computerOption).subscribe();
        return this.result;
    }

}