package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("User", "addTagFilter");
        registry.registerAuthorFilterSetter("User", "addAuthorFilter");
        registry.registerPostOrderSetter("User", "setSortingType");
        registry.registerPostListGetter("Blog", "getPosts");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "updateTitle");
        registry.registerPostBodyUpdater("Post", "updateBody");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubcomment");
        registry.registerCommentUpdater("Comment", "updateComment");
        registry.registerSubcommentUpdater("Comment", "updateComment");
        registry.registerReactionAdder("Post", "addReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "upvoteByUser");
        registry.registerCommentDownvoter("Comment", "downvoteByUser");
        registry.registerCommentListGetter("Post", "getComments");
        registry.registerSubCommentListGetter("Comment", "getSubcomments");
        registry.registerSubcommentUpvoter("Comment", "upvoteByUser");
        registry.registerSubcommentDownvoter("Comment", "downvoteByUser");
    }
}
