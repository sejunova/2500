package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("User", "addTagFilter");
        registry.registerAuthorFilterSetter("User", "addAuthorFilter");
        registry.registerPostOrderSetter("User", "setSortingType");
        registry.registerPostListGetter("Blog", "getPosts");
        registry.registerPostAdder("User", "addPost");
        registry.registerPostAdder("User", "addPost");
        registry.registerPostTitleUpdater("User", "updateTitle");
        registry.registerPostBodyUpdater("User", "updateBody");
        registry.registerPostTagAdder("User", "addTag");
        registry.registerCommentAdder("User", "addComment");
        registry.registerSubcommentAdder("User", "addSubcomment");
        registry.registerCommentUpdater("User", "updateComment");
        registry.registerSubcommentUpdater("User", "updateComment");
        registry.registerReactionAdder("User", "addReaction");
        registry.registerReactionRemover("User", "removeReaction");
        registry.registerCommentUpvoter("User", "upvoteComment");
        registry.registerCommentDownvoter("User", "downvoteComment");
        registry.registerCommentListGetter("User", "getComments");
        registry.registerSubCommentListGetter("User", "getSubcomments");
        registry.registerSubcommentUpvoter("User", "upvoteComment");
        registry.registerSubcommentDownvoter("User", "downvoteComment");
    }
}
