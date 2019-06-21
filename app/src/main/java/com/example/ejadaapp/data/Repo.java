
package com.example.ejadaapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("node_id")
    @Expose
    public String nodeId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("private")
    @Expose
    public Boolean _private;
    @SerializedName("owner")
    @Expose
    public Owner owner;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("fork")
    @Expose
    public Boolean fork;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("forks_url")
    @Expose
    public String forksUrl;
    @SerializedName("keys_url")
    @Expose
    public String keysUrl;
    @SerializedName("collaborators_url")
    @Expose
    public String collaboratorsUrl;
    @SerializedName("teams_url")
    @Expose
    public String teamsUrl;
    @SerializedName("hooks_url")
    @Expose
    public String hooksUrl;
    @SerializedName("issue_events_url")
    @Expose
    public String issueEventsUrl;
    @SerializedName("events_url")
    @Expose
    public String eventsUrl;
    @SerializedName("assignees_url")
    @Expose
    public String assigneesUrl;
    @SerializedName("branches_url")
    @Expose
    public String branchesUrl;
    @SerializedName("tags_url")
    @Expose
    public String tagsUrl;
    @SerializedName("blobs_url")
    @Expose
    public String blobsUrl;
    @SerializedName("git_tags_url")
    @Expose
    public String gitTagsUrl;
    @SerializedName("git_refs_url")
    @Expose
    public String gitRefsUrl;
    @SerializedName("trees_url")
    @Expose
    public String treesUrl;
    @SerializedName("statuses_url")
    @Expose
    public String statusesUrl;
    @SerializedName("languages_url")
    @Expose
    public String languagesUrl;
    @SerializedName("stargazers_url")
    @Expose
    public String stargazersUrl;
    @SerializedName("contributors_url")
    @Expose
    public String contributorsUrl;
    @SerializedName("subscribers_url")
    @Expose
    public String subscribersUrl;
    @SerializedName("subscription_url")
    @Expose
    public String subscriptionUrl;
    @SerializedName("commits_url")
    @Expose
    public String commitsUrl;
    @SerializedName("git_commits_url")
    @Expose
    public String gitCommitsUrl;
    @SerializedName("comments_url")
    @Expose
    public String commentsUrl;
    @SerializedName("issue_comment_url")
    @Expose
    public String issueCommentUrl;
    @SerializedName("contents_url")
    @Expose
    public String contentsUrl;
    @SerializedName("compare_url")
    @Expose
    public String compareUrl;
    @SerializedName("merges_url")
    @Expose
    public String mergesUrl;
    @SerializedName("archive_url")
    @Expose
    public String archiveUrl;
    @SerializedName("downloads_url")
    @Expose
    public String downloadsUrl;
    @SerializedName("issues_url")
    @Expose
    public String issuesUrl;
    @SerializedName("pulls_url")
    @Expose
    public String pullsUrl;
    @SerializedName("milestones_url")
    @Expose
    public String milestonesUrl;
    @SerializedName("notifications_url")
    @Expose
    public String notificationsUrl;
    @SerializedName("labels_url")
    @Expose
    public String labelsUrl;
    @SerializedName("releases_url")
    @Expose
    public String releasesUrl;
    @SerializedName("deployments_url")
    @Expose
    public String deploymentsUrl;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("pushed_at")
    @Expose
    public String pushedAt;
    @SerializedName("git_url")
    @Expose
    public String gitUrl;
    @SerializedName("ssh_url")
    @Expose
    public String sshUrl;
    @SerializedName("clone_url")
    @Expose
    public String cloneUrl;
    @SerializedName("svn_url")
    @Expose
    public String svnUrl;
    @SerializedName("homepage")
    @Expose
    public String homepage;
    @SerializedName("size")
    @Expose
    public Integer size;
    @SerializedName("stargazers_count")
    @Expose
    public Integer stargazersCount;
    @SerializedName("watchers_count")
    @Expose
    public Integer watchersCount;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("has_issues")
    @Expose
    public Boolean hasIssues;
    @SerializedName("has_projects")
    @Expose
    public Boolean hasProjects;
    @SerializedName("has_downloads")
    @Expose
    public Boolean hasDownloads;
    @SerializedName("has_wiki")
    @Expose
    public Boolean hasWiki;
    @SerializedName("has_pages")
    @Expose
    public Boolean hasPages;
    @SerializedName("forks_count")
    @Expose
    public Integer forksCount;
    @SerializedName("mirror_url")
    @Expose
    public Object mirrorUrl;
    @SerializedName("archived")
    @Expose
    public Boolean archived;
    @SerializedName("disabled")
    @Expose
    public Boolean disabled;
    @SerializedName("open_issues_count")
    @Expose
    public Integer openIssuesCount;
    @SerializedName("license")
    @Expose
    public License license;
    @SerializedName("forks")
    @Expose
    public Integer forks;
    @SerializedName("open_issues")
    @Expose
    public Integer openIssues;
    @SerializedName("watchers")
    @Expose
    public Integer watchers;
    @SerializedName("default_branch")
    @Expose
    public String defaultBranch;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Repo() {
    }

    /**
     * 
     * @param notificationsUrl
     * @param releasesUrl
     * @param pushedAt
     * @param gitTagsUrl
     * @param contentsUrl
     * @param blobsUrl
     * @param issueEventsUrl
     * @param nodeId
     * @param htmlUrl
     * @param _private
     * @param hooksUrl
     * @param description
     * @param commentsUrl
     * @param commitsUrl
     * @param labelsUrl
     * @param assigneesUrl
     * @param mergesUrl
     * @param fork
     * @param compareUrl
     * @param stargazersUrl
     * @param gitRefsUrl
     * @param deploymentsUrl
     * @param watchersCount
     * @param openIssuesCount
     * @param mirrorUrl
     * @param homepage
     * @param url
     * @param size
     * @param keysUrl
     * @param gitCommitsUrl
     * @param milestonesUrl
     * @param downloadsUrl
     * @param issueCommentUrl
     * @param pullsUrl
     * @param owner
     * @param forksUrl
     * @param hasProjects
     * @param language
     * @param statusesUrl
     * @param eventsUrl
     * @param openIssues
     * @param teamsUrl
     * @param sshUrl
     * @param contributorsUrl
     * @param stargazersCount
     * @param tagsUrl
     * @param id
     * @param hasIssues
     * @param archived
     * @param createdAt
     * @param name
     * @param treesUrl
     * @param cloneUrl
     * @param issuesUrl
     * @param license
     * @param gitUrl
     * @param forksCount
     * @param watchers
     * @param subscriptionUrl
     * @param svnUrl
     * @param archiveUrl
     * @param hasPages
     * @param languagesUrl
     * @param updatedAt
     * @param collaboratorsUrl
     * @param forks
     * @param hasDownloads
     * @param subscribersUrl
     * @param branchesUrl
     * @param fullName
     * @param hasWiki
     * @param disabled
     * @param defaultBranch
     */
    public Repo(Integer id, String nodeId, String name, String fullName, Boolean _private, Owner owner, String htmlUrl, String description, Boolean fork, String url, String forksUrl, String keysUrl, String collaboratorsUrl, String teamsUrl, String hooksUrl, String issueEventsUrl, String eventsUrl, String assigneesUrl, String branchesUrl, String tagsUrl, String blobsUrl, String gitTagsUrl, String gitRefsUrl, String treesUrl, String statusesUrl, String languagesUrl, String stargazersUrl, String contributorsUrl, String subscribersUrl, String subscriptionUrl, String commitsUrl, String gitCommitsUrl, String commentsUrl, String issueCommentUrl, String contentsUrl, String compareUrl, String mergesUrl, String archiveUrl, String downloadsUrl, String issuesUrl, String pullsUrl, String milestonesUrl, String notificationsUrl, String labelsUrl, String releasesUrl, String deploymentsUrl, String createdAt, String updatedAt, String pushedAt, String gitUrl, String sshUrl, String cloneUrl, String svnUrl, String homepage, Integer size, Integer stargazersCount, Integer watchersCount, String language, Boolean hasIssues, Boolean hasProjects, Boolean hasDownloads, Boolean hasWiki, Boolean hasPages, Integer forksCount, Object mirrorUrl, Boolean archived, Boolean disabled, Integer openIssuesCount, License license, Integer forks, Integer openIssues, Integer watchers, String defaultBranch) {
        super();
        this.id = id;
        this.nodeId = nodeId;
        this.name = name;
        this.fullName = fullName;
        this._private = _private;
        this.owner = owner;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.fork = fork;
        this.url = url;
        this.forksUrl = forksUrl;
        this.keysUrl = keysUrl;
        this.collaboratorsUrl = collaboratorsUrl;
        this.teamsUrl = teamsUrl;
        this.hooksUrl = hooksUrl;
        this.issueEventsUrl = issueEventsUrl;
        this.eventsUrl = eventsUrl;
        this.assigneesUrl = assigneesUrl;
        this.branchesUrl = branchesUrl;
        this.tagsUrl = tagsUrl;
        this.blobsUrl = blobsUrl;
        this.gitTagsUrl = gitTagsUrl;
        this.gitRefsUrl = gitRefsUrl;
        this.treesUrl = treesUrl;
        this.statusesUrl = statusesUrl;
        this.languagesUrl = languagesUrl;
        this.stargazersUrl = stargazersUrl;
        this.contributorsUrl = contributorsUrl;
        this.subscribersUrl = subscribersUrl;
        this.subscriptionUrl = subscriptionUrl;
        this.commitsUrl = commitsUrl;
        this.gitCommitsUrl = gitCommitsUrl;
        this.commentsUrl = commentsUrl;
        this.issueCommentUrl = issueCommentUrl;
        this.contentsUrl = contentsUrl;
        this.compareUrl = compareUrl;
        this.mergesUrl = mergesUrl;
        this.archiveUrl = archiveUrl;
        this.downloadsUrl = downloadsUrl;
        this.issuesUrl = issuesUrl;
        this.pullsUrl = pullsUrl;
        this.milestonesUrl = milestonesUrl;
        this.notificationsUrl = notificationsUrl;
        this.labelsUrl = labelsUrl;
        this.releasesUrl = releasesUrl;
        this.deploymentsUrl = deploymentsUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pushedAt = pushedAt;
        this.gitUrl = gitUrl;
        this.sshUrl = sshUrl;
        this.cloneUrl = cloneUrl;
        this.svnUrl = svnUrl;
        this.homepage = homepage;
        this.size = size;
        this.stargazersCount = stargazersCount;
        this.watchersCount = watchersCount;
        this.language = language;
        this.hasIssues = hasIssues;
        this.hasProjects = hasProjects;
        this.hasDownloads = hasDownloads;
        this.hasWiki = hasWiki;
        this.hasPages = hasPages;
        this.forksCount = forksCount;
        this.mirrorUrl = mirrorUrl;
        this.archived = archived;
        this.disabled = disabled;
        this.openIssuesCount = openIssuesCount;
        this.license = license;
        this.forks = forks;
        this.openIssues = openIssues;
        this.watchers = watchers;
        this.defaultBranch = defaultBranch;
    }

}
