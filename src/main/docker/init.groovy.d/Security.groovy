import hudson.security.csrf.DefaultCrumbIssuer
import jenkins.model.Jenkins

def instance = Jenkins.instanceOrNull

instance.setCrumbIssuer(new DefaultCrumbIssuer(true))
instance.save()
